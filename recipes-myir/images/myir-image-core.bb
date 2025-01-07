SUMMARY = "OpenSTLinux core image."
LICENSE = "Proprietary"

include recipes-myir/images/myir-image.inc

inherit core-image

IMAGE_LINGUAS = "en-us"

IMAGE_FSTYPES_append = " ext4.gz"

IMAGE_FEATURES += "\
    package-management  \
    ssh-server-dropbear \
    "

#
# INSTALL addons
#
CORE_IMAGE_EXTRA_INSTALL += " \
    resize-helper \
    packagegroup-framework-core-base    \
    packagegroup-framework-tools-base   \
    ${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'packagegroup-optee-core', '', d)}   \
    ${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'packagegroup-optee-test', '', d)}   \
    socat \
    python3 \
    python3-pyserial \
    python3-pyelftools \
    libconfig \
    sepia-host \
    lua \
    json-c \
    jq \
    swupdate \
    swupdate-tools \
    swupdate-www \
    "
