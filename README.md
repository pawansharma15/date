About Application
---
An Rest Application that takes two ISO dates as input and calculated the number of days inbetween them. The dates goes as values to two parameters `date1` and `date2`. The dates can go in any order i.e. `date1` can have smaller date than `date2` and vice versa.

The range of the dates this application can take is 
Min - 0001-01-01
Max - 9999-12-31

```
GET difference?date1=YYYY-MM-DD&date2=YYYY-MM-DD
Host datedifference.herokuapp.com
```

Example
----
https://datedifference.herokuapp.com/difference?date1=0001-01-01&date2=9999-12-31

Response <br/>
```
200 Ok
```
```
content-type: application/json
```
```
{
  "result": 3652058
  "error": false
}
```

Various Responses
---
If the date provided is not in IOS format ot would return 400 bad request 
```
400
```
```
{
  "error": true,
  "message": "Please provide date as YYYY-MM-DD"
}
```
Other various standart HTTP response and status is also supported.

Limitation
---
this app is build using Java Spring Boot and handles all errors and exception within the Spring framework. But it does not handle the errors and exceptions of the webserver. If the request is blocked or failed by the webserver then the response would not be in JSOn but would be a static HTML page.
