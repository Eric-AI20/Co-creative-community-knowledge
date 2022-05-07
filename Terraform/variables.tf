variable "flavor" { default = "m1.large" }
variable "image" { default = "Debian Buster 10.11.1 20211029" }
variable "name1" { default = "CommunityApplication_Debian" }

variable "keypair" { default = "gitlab_project_keypair" } # you may need to change this
variable "network" { default = "yihangNetwork" }   # you need to change this

variable "pool" { default = "cscloud_private_floating" }
variable "server1_script" { default = "./install-jenkins-debian.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tf_securityMat_1" }
