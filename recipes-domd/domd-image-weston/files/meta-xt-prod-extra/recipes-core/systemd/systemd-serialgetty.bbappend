do_install_append_kingfisher() {
   # disable serial-getty@ttyS0.service.
   if [ -f ${D}${sysconfdir}/systemd/system/getty.target.wants/serial-getty@ttyS0.service ]; then
         rm -f ${D}${sysconfdir}/systemd/system/getty.target.wants/serial-getty@ttyS0.service
   fi
}
