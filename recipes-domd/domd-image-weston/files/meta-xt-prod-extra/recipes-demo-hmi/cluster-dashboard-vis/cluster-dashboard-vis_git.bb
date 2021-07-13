SRC_URI = "gitsm://github.com/xen-troops/agl-cluster-demo-vis.git;protocol=https"
SRCREV  = "c9e1ec4486ef0ec595f7d24e966e86c0d3c65471"

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
