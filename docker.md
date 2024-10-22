

### Step-by-Step Instructions to Install Docker on EC2 and Run the `movieapi:latest` Docker Container

---

### Step 1: Install Docker on the EC2 Instance

1. **Update the package database**:
   Run the following command to make sure your system packages are up to date:
   ```bash
   sudo su     (to get into sudo mode)
   sudo yum update -y
   ```

2. **Install Docker**:
   Use the following command to install Docker:
   ```bash
   sudo yum install docker
   ```

3. **Start the Docker service**:
   After installing Docker, start the Docker service:
   ```bash
   sudo service docker start
   ```

4. **Verify Docker Installation**:
   To confirm that Docker is installed and running, check the Docker version:
   ```bash
   docker --version
   ```
   You should see the Docker version information.

---

### Step 2: Configure Security Group

Before running your application, make sure the EC2 security group allows inbound traffic on port **8080** (or any port you will map to).

1. **Open your EC2 Security Group settings** in the AWS console.
2. **Add a new inbound rule** for `HTTP` or `Custom TCP` with port `8080` and set it to allow access from `Anywhere` (0.0.0.0/0) for simplicity, or restrict it to specific IPs for security.

---

### Step 3: Log In to Docker Hub

To pull your Docker image (`movieapi:latest`) from Docker Hub, log in using your Docker credentials:

```bash
docker login
```

- You will be prompted to enter your Docker Hub username and password.

---

### Step 4: Pull and Run the `movieapi` Docker Container

1. **Pull the Docker image**:
   Use the following command to pull the `movieapi:latest` image from Docker Hub (replace `your-dockerhub-username` with your actual username):
   ```bash
   docker pull your-dockerhub-username/movieapi:latest
   ```

   For example:
   ```bash
   docker pull topkuber/movieapi:latest
   ```

2. **Run the Docker container**:
   Once the image is pulled, run the container with the following command:
   ```bash
   docker run -d -p 8080:8080 your-dockerhub-username/movieapi:latest
   ```

   - `-d`: Runs the container in detached mode (in the background).
   - `-p 8080:8080`: Maps port 8080 on the EC2 instance to port 8080 inside the container.

   Example:
   ```bash
   docker run -d -p 8080:8080 topkuber/movieapi:latest
   ```

3. **Verify the container is running**:
   Run the following command to see your running containers:
   ```bash
   docker ps
   ```

   You should see your `movieapi` container listed.

---

### Step 5: Access the Movie API Application

Once the container is running, you can access the Movie API application through the public IP address of your EC2 instance.

1. **Find your EC2 instance's public IP** in the AWS EC2 dashboard.
2. **Open your web browser** and navigate to the following URL:
   ```text
   http://your-ec2-public-ip:8080/hello
   ```

   Replace `your-ec2-public-ip` with your instance's actual public IP address. You should see the message:
   ```
   Welcome to the Movie API!
   ```

---

### Step 6: Manage Your Docker Containers

Here are some common Docker management commands for managing your running `movieapi` container:

1. **Stop the container**:
   ```bash
   docker stop <container-id>
   ```

   Replace `<container-id>` with the ID of the `movieapi` container, which you can find by running `docker ps`.

2. **Start the container**:
   ```bash
   docker start <container-id>
   ```

3. **Remove the container**:
   ```bash
   docker rm <container-id>
   ```

4. **List all containers (including stopped ones)**:
   ```bash
   docker ps -a
   ```

---

### Tutorial: Building and Pushing a Docker Image

This tutorial will guide you through building a Docker image from your Dockerfile and pushing it to Docker Hub or any other Docker registry.

#### Prerequisites
- Docker installed on your local machine.
- Docker Hub account (or another Docker registry) if you want to push your image.
- Dockerfile ready in your project directory.

### Step 1: Build the Docker Image

1. **Navigate to your project directory**:
   Open your terminal and navigate to the directory where your Dockerfile is located.
   ```bash
   cd /path/to/your/project
   ```

2. **Build the Docker image**:
   Use the `docker build` command to build your image. Replace `your-image-name` with a name for your Docker image.
   ```bash
   docker build -t your-image-name .
   ```
   - `-t` tags the image with a name.
   - `.` specifies the current directory as the build context.

3. **Verify the image**:
   Check if your image was built successfully by running:
   ```bash
   docker images
   ```
   You should see your image listed with the name you provided.

### Step 2: Tag the Docker Image

Before pushing your image to a Docker registry, you need to tag it properly. The tag format typically follows:
```
<registry-url>/<username>/<image-name>:<tag>
```

1. **Tag the image**:
   If you’re using Docker Hub, it would look like this:
   ```bash
   docker tag your-image-name your-dockerhub-username/your-image-name:latest
   ```
   - Replace `your-dockerhub-username` with your Docker Hub username.
   - Replace `latest` with a version tag if needed (e.g., `v1.0`).

### Step 3: Push the Docker Image to Docker Hub

1. **Log in to Docker Hub**:
   Make sure you’re logged in to Docker Hub (or your chosen registry).
   ```bash
   docker login
   ```
   Enter your Docker Hub credentials when prompted.

2. **Push the image**:
   ```bash
   docker push your-dockerhub-username/your-image-name:latest
   ```
   This command pushes your image to Docker Hub. You should see the layers being uploaded.

### Step 4: Verify the Pushed Image

1. Go to your Docker Hub repository page (https://hub.docker.com/r/your-dockerhub-username/your-image-name) and verify that the image has been pushed successfully.
2. You can also pull the image back to ensure it’s working:
   ```bash
   docker pull your-dockerhub-username/your-image-name:latest
   ```

### Summary

You've now built and pushed a Docker image using the following steps:
- **Build the image** using your Dockerfile.
- **Tag the image** properly for the Docker registry.
- **Push the image** to Docker Hub or another Docker registry.

You can now use this image in your Docker deployments!