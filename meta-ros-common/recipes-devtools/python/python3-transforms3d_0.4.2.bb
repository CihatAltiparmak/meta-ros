

SUMMARY = "Functions for 3D coordinate transformations"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://setup.py;beginline=36;endline=36;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI[sha256sum] = "e8b5df30eaedbee556e81c6938e55aab5365894e47d0a17615d7db7fd2393680"

inherit pypi python_setuptools_build_meta

DEPENDS += " \
    python3-versioneer-native \
"

RDEPENDS:${PN} += "\
    python3-numpy \
    python3-versioneer \
"

BBCLASSEXTEND = "native nativesdk"