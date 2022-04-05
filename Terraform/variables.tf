variable "flavor" { default = "m1.large" }
variable "image" { default = "CentOS 8 20200402" }
variable "name1" { default = "CentOS Takeaway from Jenkins" }

variable "keypair" { default = "tmp" } # you may need to change this
variable "network" { default = "ianNetwork" }   # you need to change this

variable "pool" { default = "cscloud_private_floating" }
variable "server1_script" { default = "./server1.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tf_security_takeaway" }
