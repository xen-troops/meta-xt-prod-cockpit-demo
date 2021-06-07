FILESEXTRAPATH_prepend := "${THISDIR}/files"

SRC_URI_kingfisher = " file://weston.ini "

do_install_kingfisher() {
    install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}

