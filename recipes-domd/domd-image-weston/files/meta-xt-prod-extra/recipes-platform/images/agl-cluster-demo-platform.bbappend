
IMAGE_INSTALL_remove="guest-addons-display-manager-service"

#IMAGE_INSTALL_append=" \
#      aos-certificates \
#"

python __anonymous () {
    if d.getVar("AOS_VIS_PACKAGE_DIR", True):
        # VIS is from prebuilt binaries
        d.appendVar("IMAGE_INSTALL", " ca-certificates")
    else:
        # VIS is from sources
        d.appendVar("IMAGE_INSTALL", " aos-vis")
}

install_aos () {
    if [ ! -z "${AOS_VIS_PACKAGE_DIR}" ];then
        opkg install ${AOS_VIS_PACKAGE_DIR}/aos-vis
    fi
}

ROOTFS_POSTPROCESS_COMMAND += "install_aos; "
