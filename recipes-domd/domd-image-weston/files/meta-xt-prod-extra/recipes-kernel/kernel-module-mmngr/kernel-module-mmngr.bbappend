FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://0001-Use-first-reserved-addr-from-IOMEM-area-as-MM_LOSSY_.patch \
"

# original recipe defines MMNGR_SALVATORX for all the boards, e.g. x3ulcb
MMNGR_CFG_rcar = "MMNGR_SALVATORX"
