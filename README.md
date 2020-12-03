# Comic-API


On this repository I created an API using JAVA and SPRING, that allows the users to retrieve json Data from different
 online webcomics such us https://xkcd.com/ or http://www.poorlydrawnlines.com. Currently the API is still in development
 and only allows to retrieve data from xkcd and summarize data with the most important fields:

 * Get compiled summarize data (only from xkcd)
 * Get multiple comics from xkcd
 * Get xkcd latest comic
 
 ToDo
 * Get summarize data compiled from xkcd and poorlydrawlines
 * ...

I deployed the application in Heroku, so you can interact with the API here: 

## Local Installation

After you cloned the git repository, go inside the main project folder and execute the next command to run and build
the application: 

```bash
docker-compose up
```

## Local Usage
The application is running on localhost:8080, so you will need to  

## Get compilation
#Request
`GET /compilation`

## Get compilation

`GET /compilation`