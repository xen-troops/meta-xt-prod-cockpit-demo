FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DESCRIPTION = ""
SECTION = "extras"
PR = "r0"
LICENSE = "CLOSED"

SRC_URI_append = "\
    file://rootCA.pem \
"

do_install_append() {
    install -d ${D}${sysconfdir}/ssl/certs
    install -m 0644 ${WORKDIR}/rootCA.pem ${D}${sysconfdir}/ssl/certs/
    ln -sfr ${D}${sysconfdir}/ssl/certs/rootCA.pem ${D}${sysconfdir}/ssl/certs/dc9c08a1.0
}

