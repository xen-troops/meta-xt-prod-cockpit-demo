FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "displaymanager-ready"
SECTION = "extras"
PR = "r0"
LICENSE = "CLOSED"
inherit systemd

SRC_URI = " \
    file://display-manager-ready \
    file://display-manager-ready.service \
"
RDEPENDS_${PN} += "bash"

SYSTEMD_SERVICE_${PN} = "display-manager-ready.service"

do_install() {
    install -D -m 0755 ${WORKDIR}/display-manager-ready ${D}${bindir}/display-manager-ready
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/display-manager-ready.service ${D}${systemd_system_unitdir}
}

