terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "3.74.0"
      #version = "4.8.0"
    }
  }

}

provider "aws" {
  region = "us-east-2"
}

# resource "aws_instance" "terraformintance" {
#   ami           = "ami-0c55b159cbfafe1f0"
#   instance_type = "t2.micro"
#   tags = {
#     Name = "ec2-grupo7"
#   }
# }

resource "aws_instance" "web" {
  ami           = "ami-00ee4df451840fa9d" #Amazon Linux AMI
  instance_type = "t2.micro"
  security_groups = [aws_security_group.TF_SG.name]
  #first method
  key_name = "TF_key"
  

  tags = {
    Name = "Terraform-Ec2-C12"
  }
}

# resource "aws_vpc" "myvpc"{
#     cidr_block = "10.0.0.0/16"
#     tags = {
#         Name = "MyVPC-C12"
#     }
# }

#securitygroup using Terraform

resource "aws_security_group" "TF_SG" {
  name        = "security group using Terraform"
  description = "security group using Terraform"
  vpc_id      = "vpc-04870f57d7cd007c4"

  ingress {
    description      = "HTTPS"
    from_port        = 443
    to_port          = 443
    protocol         = "tcp"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  ingress {
    description      = "HTTP"
    from_port        = 80
    to_port          = 80
    protocol         = "tcp"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  ingress {
    description      = "SSH"
    from_port        = 22
    to_port          = 22
    protocol         = "tcp"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  tags = {
    Name = "TF_SG"
  }
}

#keypair second method for Key_pair

resource "aws_key_pair" "TF_key" {
  key_name   = "TF_key"
  public_key = tls_private_key.rsa.public_key_openssh
}

resource "tls_private_key" "rsa" {
  algorithm = "RSA"
  rsa_bits  = 4096
}

resource "local_file" "TF-key" {
    content  = tls_private_key.rsa.private_key_pem
    filename = "tfkey"
}


# variable "s3_bucket_names" {
#   type    = list(any)
#   default = ["g7-front-bucket.app", "g7-images-bucket.app"]
# }

# resource "aws_s3_bucket" "rugged_buckets" {
#   #count         = length(var.s3_bucket_names) //count will be 2
#   bucket = var.s3_bucket_names[1]
#   #   acl           = "private"
#   #   region        = "us-east-2"
#     force_destroy = true
#   lifecycle {
#     prevent_destroy = false
#   }
#   versioning {
#     enabled = true

#   }
# }

# resource "aws_s3_bucket" "www_bucket" {
#   bucket = var.s3_bucket_names[0]
#   acl    = "public-read"

#   website {
#     index_document = "index.html"
#     error_document = "404.html"
#   }

#   force_destroy = true
#   lifecycle {
#     prevent_destroy = false
#   }
#   versioning {
#     enabled = true

#   }
# }



#ACA PARA ABAJO ES CODIGO DE MUESTRA

# module "s3" {
#     source = "<path-to-S3-folder>"
#     #bucket name should be unique
#     bucket_name = "<Bucket-name>"       
# }

# resource "aws_s3_bucket" "example" {
#   bucket = "mybucket"
# }

# resource "aws_s3_bucket_cors_configuration" "example" {
#   bucket = aws_s3_bucket.example.id

#   cors_rule {
#     allowed_headers = ["*"]
#     allowed_methods = ["PUT", "POST"]
#     allowed_origins = ["https://s3-website-test.hashicorp.com"]
#     expose_headers  = ["ETag"]
#     max_age_seconds = 3000
#   }

#   cors_rule {
#     allowed_methods = ["GET"]
#     allowed_origins = ["*"]
#   }
# }

