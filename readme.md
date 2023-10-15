# Paperless UI

## How to set it up

Make sure that you are in the root folder(the folder containing the docker-compose file). 

Execute following command:
``` bash
docker-compose up
```
It will build the Rest-Api and the Paperless UI.
The Api should be running on ``` Port:8081```. The UI is running on ``` Port:8080``` [http://localhost:8080/en-GB/dashboard](http://localhost:8080/en-GB/dashboard)

## Troubleshooting
If you are having troubles accessing the Paperless UI try deleting the docker containers and clear your docker cache.
``` bash 
docker builder prune
```
Then retry the process. If you are still having issues, try to delete the cache of your browser. Additionally, it might help to use your native console application.