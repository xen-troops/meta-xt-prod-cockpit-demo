SRC_URI = "git://github.com/xen-troops/optee_os.git;branch=3.9-xt-linux;protocol=https"

EXTRA_OEMAKE_append = " \
    CFG_RPMB_FS=y \
    CFG_RPMB_WRITE_KEY=y \
    CFG_EARLY_TA=y \
    CFG_IN_TREE_EARLY_TAS=avb/023f8f1a-292a-432b-8fc4-de8471358067 \
    "
