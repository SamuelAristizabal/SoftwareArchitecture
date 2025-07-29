//Requiere node.js
const htto = require("http");
const fs = require("fs");
const path = require("path");

const port = 80;

const products = [
    { id: 1, name: "Producto 1", price: 100 },
    { id: 2, name: "Producto 2", price: 200 },
    { id: 3, name: "Producto 3", price: 300 }
];

const server = htto.createServer((req, res) => {
    res.setHeader("Content-Type", "text/html");
    res.setHeader("Access-Control-Allow-Origin", "*");
    const filePath = path.join(__dirname, req.url === '/' ? 'index.html' : req.url);
    fs.readFile(filePath, "utf 8", (err, data) => {
        if (err) {
            res.writeHead(404, { "Content-Type": "text/plain" });
            res.end("404 Not Found");
            return;
        }
        res.writeHead(200, { "Content-Type": "text/html" });
        res.end(data);
    });
    res.end('Hola amigos');

});

server.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:${port}`);
});