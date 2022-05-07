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

cd /
cd home/
cd debian/
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
pwd

gradle build
gradle bootrun
