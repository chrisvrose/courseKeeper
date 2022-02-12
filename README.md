# CourseKeeper

This is a POC Springboot application that explores doing CRUD with a DB, with relations. 
Kept for reference.

## How to use

`compose.yml` contains a mock DB that can be easily started.
Set `MYSQL_PASSWORD` & `MYSQL_ROOT_PASSWORD` in a `.env` file and do `docker-compose up -d` to bring up a database to use along with this.
Ofc, any other DB instance works well too.


## Note

- This has a slight weird thing that the arrangement is based as 'Chapters of Courses' and each course has a bytearray for storing file content. Please refer to each controller for reference.
- Responses are based off the slightly opinionated Telegram API style, with a shape {"ok":boolean,"response":`<whatever you wanted>`}
- Refer to [api.rest](api.rest) for API examples