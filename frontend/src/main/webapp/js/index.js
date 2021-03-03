const endpoints = [
    "http://localhost:8080/mork",
    "http://localhost:8080/treu/get",
    "http://localhost:8080/lou/ping",
    "http://localhost:8080/cj/testmessage",
    "http://localhost:8080/bobby/albums",
    "http://localhost:8080/newton/newtonEndpoint"
]

const pingServices = () => {
    const ping = (url) => {
        return new Promise((resolve, reject) => {
            const req = new XMLHttpRequest();
            req.onreadystatechange = function() {
                if (req.readyState != 4) return; // Not there yet
                if (req.status != 200) {
                    resolve({url, status:req.status, res:req.statusText});
                    return;
                }
                resolve({url, status:req.status, res:req.responseText});
            };
            req.open("GET", url, true);
            req.send();
        });
    };

    const pong = endpoints.map((url)=>{return ping(url);});

    Promise.all(pong).then((vals)=>{
        const div = document.querySelector('._results');
        div.innerHTML = '';
        vals.forEach((r) => {
            div.innerHTML += `[${r.status}] ${r.url} :: ${r.res}<br/>`;
        });
    })
};