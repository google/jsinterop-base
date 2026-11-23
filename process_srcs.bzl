"""Uncomments code that is commented with the given markers, e.g. '// J2CL_ONLY '. The markers are
replaced with whitespace to ensure all character offset position references remain accurate."""

_PROCESS_SRCS_CMD = """
# Exit on any command failure, if a variable is unset, or a pipeline failure (respectively).
set -euo pipefail

# Build a sed expression for each marker that replaces '// <marker> ' with as many spaces.
declare -a sed_args
for marker in %s; do
  prefix="// $${marker} "
  sed_args+=(-e "s|$${prefix}|$${prefix//?/ }|g")
done

tmpdir=$$(mktemp -d)
# Ensure we cleanup the tmpdir on exit
trap "rm -rf $${tmpdir}" EXIT

# Mutate the source files in a tmp file. We'll build up a mapping of <original_file>=<tmp file> that
# can be passed into zipper so that we maintain the original file paths within the zip.
declare -a file_mapping
for src in $(SRCS); do
  tmpfile=$$(mktemp "$${tmpdir}/tmp.XXXXXXXXX")
  file_mapping+=("$${src}=$${tmpfile}")
  sed "$${sed_args[@]}" $${src} > $${tmpfile}
done

# Zip everything up using the mapping we built.
$(execpath @bazel_tools//tools/zip:zipper) c $@ "$${file_mapping[@]}"
"""

def process_srcs(markers, **kwargs):
    """Uncomments '// <MARKER> ' prefixes in srcs and zips them into a srcjar."""
    native.genrule(
        cmd = _PROCESS_SRCS_CMD % " ".join(markers),
        tools = ["@bazel_tools//tools/zip:zipper"],
        **kwargs
    )
