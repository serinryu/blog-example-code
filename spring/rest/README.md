# Environment
To see how to get data from Server using Fetch API, separate back and front on different servers.
- Server : Spring Boot Embedded Web Server (port : 8080)
- Client : VSCode Live Server (port : 5050)

## Test for RequestDataController
- Server : http://localhost:8080/test/givejsondata4
- Client : http://127.0.0.1:5500/example.html 

jsonexample.html
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<button id="postData">
    Button
</button>
<script>
    const $postDataButton = document.querySelector("#postData")

    const postData = event => {
        console.log("You pushed the button");

        fetch("http://localhost:8080/test/givejsondata2", { <!-- Server URL -->
            method: 'post',
            headers: {
                'content-type': 'application/json'
            },
            body : JSON.stringify({
                name : "Chris",
                age : "25"
            })
        })
        .then((response) => response.json())
        .then((json) => console.log(json))
    }
    
    $postDataButton.addEventListener("click", postData);

</script>
</body>
</html>
```

## Test for RestAPIController
This is using REST API.
- Server : http://localhost:8080/resttest/givejsondata4
- Client : http://127.0.0.1:5500/example.html

jsonexample2.html
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<button id="postData">
    Button
</button>
<script>
    const $postDataButton = document.querySelector("#postData")

    const postData = event => {
        console.log("You pushed the button");

        fetch("http://localhost:8080/resttest/givejsondata2", { <!-- Server URL -->
            method: 'post',
            headers: {
                'content-type': 'application/json'
            },
            body : JSON.stringify({
                name : "Chris",
                age : "25"
            })
        })
        .then((response) => response.json())
        .then((json) => console.log(json))
    }
    
    $postDataButton.addEventListener("click", postData);

</script>
</body>
</html>
```