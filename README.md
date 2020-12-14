# Comic-API


On this repository I created an API using JAVA and SPRING, that allows the users to retrieve json Data from different
online webcomics such us https://xkcd.com/ or http://www.poorlydrawnlines.com. Currently the API allows to retrieve 
data from xkcd specifically and compile data from both xkcd and PoorlyDrawnLines with the most important fields:

 * Get compiled summarize data from xkcd
 * Get multiple comics from xkcd
 * Get xkcd latest comic
 * Get summarize data compiled from xkcd and poorlydrawlines
 * ...

I deployed the application in Heroku, so you can interact with the API here: https://challenge-comic.herokuapp.com/

## Local Installation

After you cloned the git repository, go inside the main project folder and execute the next command to run and build
the application: 

```bash
docker-compose up --build
```

## Local Usage
The application is running on localhost:8080, so you will need to append your request to this path. 

## Get compilation
#Request
`GET /compilation`

## Get xkcd comics
#Request

`GET /xkcd/comics`

## Get xkcd last comic
#Request

`GET /xkcd/lastcomic`