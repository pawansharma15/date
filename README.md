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
