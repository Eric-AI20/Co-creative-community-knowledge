#!/bin/bash

whoami
echo logged in as $USER.
echo in directory $PWD

sudo apt update

echo "installing MariaDB..."
# sudo yum install mysql -y
sudo apt install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb

sudo mysql -e "USE mysql; UPDATE user SET password=PASSWORD('comsc') WHERE User='root' AND Host = 'localhost'; UPDATE mysql.user SET plugin = 'mysql_native_password' WHERE user = 'root' AND plugin = 'unix_socket'; FLUSH PRIVILEGES;"
sudo systemctl restart  mariadb
sudo systemctl enable mariadb

sudo apt install git -y

echo "needs to be in root account"
cd root
sudo touch .ssh/known_hosts
sudo ssh-keyscan git.cardiff.ac.uk >> .ssh/known_hosts
sudo chmod 644 .ssh/known_hosts

echo "now needs to be in centos user directory"
cd /home/debian
cat << `EOF` >> gitlab_deploy_keypair.key
-----BEGIN OPENSSH PRIVATE KEY-----
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
-----END OPENSSH PRIVATE KEY-----
`EOF`
chmod 400 gitlab_deploy_keypair.key
sudo ssh-agent bash -c 'ssh-add gitlab_deploy_keypair.key; git@git.cardiff.ac.uk:c21083456/co-creative-community-knowledge-group-1.git' -y

cd co-creative-community-knowledge-group-1/
mysql -uroot -pcomsc < src/BuildDB.sql


echo "Installing Java 11..."
sudo apt install -y openjdk-11-jdk
java -version

sudo apt install -y curl unzip

echo "Installing gradle..."
curl -O https://downloads.gradle-dn.com/distributions/gradle-7.2-bin.zip
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-7.2-bin.zip
export PATH=$PATH:/opt/gradle/gradle-7.2/bin
gradle -v


gradle build
gradle bootrun
