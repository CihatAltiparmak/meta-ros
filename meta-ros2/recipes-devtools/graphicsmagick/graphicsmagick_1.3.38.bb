SUMMARY = "Swiss army knife of image processing"
HOMEPAGE = "http://www.graphicsmagick.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://Copyright.txt;md5=d46c64029c86acbab3a4deffc237d406"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/GraphicsMagick-${PV}.tar.xz"

# SRC_URI[md5sum] = "d46c64029c86acbab3a4deffc237d406"
SRC_URI[sha256sum] = "d60cd9db59351d2b9cb19beb443170acaa28f073d13d258f67b3627635e32675"

S = "${WORKDIR}/GraphicsMagick-${PV}"

DEPENDS += " \
    openmp \
    libtool \
"

DEPENDS += "jpeg zlib libpng tiff flex-native"

inherit autotools
# prefix = "/usr/local"

# FILES:${PN} += " \
#     ${datadir}/GraphicsMagick-1.3.45/config \
#     ${libdir}/GraphicsMagick-1.3.45/config \
#     ${libdir}/GraphicsMagick-1.3.45/modules-Q8 \
#     ${prefix}/local \
# "

FILES:${PN} += " \
  /usr/lib/GraphicsMagick-1.3.38 \
  /usr/lib/GraphicsMagick-1.3.38/config \
  /usr/lib/GraphicsMagick-1.3.38/config/type.mgk \
  /usr/lib/GraphicsMagick-1.3.38/config/type-ghostscript.mgk \
  /usr/lib/GraphicsMagick-1.3.38/config/delegates.mgk \
  /usr/lib/GraphicsMagick-1.3.38/config/type-windows.mgk \
  /usr/lib/GraphicsMagick-1.3.38/config/type-solaris.mgk \
  /usr/share/GraphicsMagick-1.3.38 \
  /usr/share/GraphicsMagick-1.3.38/config \
  /usr/share/GraphicsMagick-1.3.38/config/log.mgk \
  /usr/share/GraphicsMagick-1.3.38/config/modules.mgk \
  /usr/share/GraphicsMagick-1.3.38/config/colors.mgk \
"

EXTRA_OECONF += "--enable-shared=yes"

# CACHED_CONFIGUREVARS += " ac_cv_path_MVDelegate='${bindir}/mv'"

# do_install:prepend() {
#     install -d ${D}/${prefix}/local
# }

do_install:append() {
    sed -i -e 's|-ffile-prefix-map[^ ]*||g; s|-fdebug-prefix-map[^ ]*||g; s|-fmacro-prefix-map[^ ]*||g; s|${STAGING_DIR_TARGET}||g' ${D}${libdir}/pkgconfig/*.pc

    # The config scripts contain the build configuration and are not needed on the target
    # The pkgconfig files are available as an alternative
    rm ${D}${bindir}/GraphicsMagick-config
    rm ${D}${bindir}/GraphicsMagick++-config
}

