SUMMARY     = "A wrapper library of libwindowmanager for Qt Application in AGL"
SECTION     = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS = "qtbase libwindowmanager"
RDEPENDS_${PN} = "libwindowmanager"

inherit qmake5

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/libqtwindowmanager.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "3ff07151af5040842dd1e56d8312ee39cc50f533"
S = "${WORKDIR}/git"
PV = "1.0+git${SRCPV}"
