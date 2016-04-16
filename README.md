# ProjetJavaScore
Projet Java Score API (AFONSO Benjamin &amp; CABOURG Max)

## API Details

**API ID**: 108875

**Write API Key**: VAZH2UAGFI51ENX0
**Read-only API Key**: BEKTSYUFNAB5RV33

### Interact with channel feed:

***Update Channel Feed (GET)***

```
GET https://api.thingspeak.com/update?api_key=VAZH2UAGFI51ENX0&field1=0
```

***Update Channel Feed (POST)***

```
POST https://api.thingspeak.com/update.json
     api_key=VAZH2UAGFI51ENX0
     field1=73
```


***Get a Channel Feed***

```
GET https://api.thingspeak.com/channels/108875/feeds.json?results=2
```

***Get a channel field feed***

```
GET https://api.thingspeak.com/channels/108875/fields/1.json?results=2
```

***Get Status Updates***
```
GET https://api.thingspeak.com/channels/108875/status.json
```
