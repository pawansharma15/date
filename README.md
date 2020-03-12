About Application
---
A Rest Application that takes two ISO dates as input and calculated the number of days inbetween them. The dates goes as values to two parameters `date1` and `date2`. The dates can go in any order i.e. `date1` can have smaller date than `date2` and vice versa.

The range of the dates this application can take is <br/>
Min - 0001-01-01 <br/>
Max - 9999-12-31 <br/>

Outside this range the application would return ```400 Bad Request```

GET Request detials
```
GET difference?date1=YYYY-MM-DD&date2=YYYY-MM-DD
Host datedifference.herokuapp.com
```

Successfull Response
```
200 Ok
content-type: application/json
{
  "result": <Number of days as INT>
  "error": false
}
```

Error Response
```
xxx - <non 200 response code>
content-type: application/json
{
  "message": <ERROR MESSAGE>
  "error": true
}
```

Example
----
https://datedifference.herokuapp.com/difference?date1=0001-01-01&date2=9999-12-31

Response <br/>
```
200 Ok
content-type: application/json
{
  "result": 3652058
  "error": false
}
```

Various Responses
---
If the date provided is not in IOS format it would return with ```400 bad request```
```
https://datedifference.herokuapp.com/difference?date1=0001-01-01&date2=9999-12-311111
400
{
  "error": true,
  "message": "Please provide date as YYYY-MM-DD"
}
```
Other various standart HTTP response and status is also supported.

Limitation
---
This app is build using Java Spring Boot and handles all errors and exception within the Spring framework. But it does not handle the errors and exceptions of the webserver. If the request is blocked or is failed by the webserver then the response would not be in JSON but would be a static HTML page, that Tomcat returns.
