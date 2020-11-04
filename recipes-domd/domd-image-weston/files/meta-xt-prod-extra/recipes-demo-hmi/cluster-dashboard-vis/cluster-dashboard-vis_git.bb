SRC_URI = "gitsm://github.com/xen-troops/agl-cluster-demo-vis.git;protocol=https"
SRCREV  = "36622ac7a815f5c8feabf5f405b25ddcf398cda5"

LICENSE     = "Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

PV = "1.0+git${SRCPV}"
S  = "${WORKDIR}/git"

# build-time dependencies
DEPENDS += "qtquickcontrols2 qtwebsockets qlibwindowmanager"

inherit pkgconfig cmake_qt5 aglwgt

RDEPENDS_${PN} += " \
	qlibwindowmanager \
	qtquickcontrols \
	qtquickcontrols-qmlplugins \
	qtquickcontrols2 \
	qtquickcontrols2-qmlplugins \
	qtwebsockets \
	qtwebsockets-qmlplugins \
"

VISSERVER = "10.0.0.1    wwwivi"

pkg_postinst_ontarget_${PN} () {
    if ! grep -q '${VISSERVER}' $D${sysconfdir}/hosts ; then
        echo '${VISSERVER}' >> $D${sysconfdir}/hosts
    fi
}
