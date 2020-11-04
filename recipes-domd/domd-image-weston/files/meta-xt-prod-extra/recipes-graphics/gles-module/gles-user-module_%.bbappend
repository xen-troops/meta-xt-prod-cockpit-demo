EXTRA_OEMAKE += "BIN_DESTDIR=${localstatedir}/local/bin"
EXTRA_OEMAKE += "SHARE_DESTDIR=${localstatedir}/local/share"

FILES_${PN}_append = "${localstatedir}/local/share/* \
                      ${localstatedir}/local/bin/* \
"
