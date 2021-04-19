require include/multimedia-control.inc

DEPENDS += " \
    weston-ini-conf \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install() {
    install -Dm755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/weston
    install -Dm644 ${WORKDIR}/weston.env ${D}${sysconfdir}/default/weston

    # Install Weston systemd service and accompanying udev rule
    install -D -p -m0644 ${WORKDIR}/weston@.service ${D}${systemd_system_unitdir}/weston@.service
    sed -i -e s:/etc:${sysconfdir}:g \
            -e s:/usr/bin:${bindir}:g \
            -e s:/var:${localstatedir}:g \
            ${D}${systemd_unitdir}/system/weston@.service
    install -D -p -m0644 ${WORKDIR}/71-weston-drm.rules \
            ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules
    # Install weston-start script
    install -Dm755 ${WORKDIR}/weston-start ${D}${bindir}/weston-start
    sed -i 's,@DATADIR@,${datadir},g' ${D}${bindir}/weston-start
    sed -i 's,@LOCALSTATEDIR@,${localstatedir},g' ${D}${bindir}/weston-start

    sed -i "s/multi-user.target/rc.pvr.service getty.target\nRequires=rc.pvr.service/" \
        ${D}/${systemd_system_unitdir}/weston@.service

    sed -i "s/Conflicts=plymouth-quit.service/Conflicts=plymouth-quit.service getty@tty1.service/" \
        ${D}/${systemd_system_unitdir}/weston@.service
}

