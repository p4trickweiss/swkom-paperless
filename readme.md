# Paperless UI

## Prerequisites
Before setting up the Paperless UI, make sure you have the following prerequisites:
- Docker installed on your system
- You are in the root folder containing the 'docker-compose.yml' file

## Installation Steps
1. Navigate to the root folder where the 'docker-compose.yml' file is located
2. Execute the following command:
``` bash
docker-compose up
```
3. This command will build and deploy the Paperless Rest API and the Paperless UI. Once the setup is complete, the Paperless Rest API will be accessible on Port 8081, and the Paperless UI will be available at http://localhost:8080/en-GB/dashboard.

## Troubleshooting
- **Trouble Accessing the Paperless UI:** If you have trouble accessing the Paperless UI, try the following:
    - Delete the Docker containers by running the following command:
``` bash 
docker builder prune
```
After pruning the builder, retry the setup process

- **Browser Cache:** Clear your browser's cache if you still encounter issues. Sometimes, cached data can cause problems.
- **Native Console Application:** If the issues persist, consider using your system's native console application.