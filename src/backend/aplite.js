const util = require('util');
const http = require('http');
const fs = require('fs');
const queries = require('./queries');
const port = 8000;
const hostname = "127.0.0.1";

sendAdminLogin = (request, response) => {
  response.end(fs.readFileSync("./html/index.html"));
}

async function _readBody(request) {
  let body = [];
  return new Promise(function (resolve, reject) {
    request.on('data', (chunk) => {
      body.push(chunk);
    }).on('end', () => {
      body = Buffer.concat(body).toString();
      resolve(body.substring(1, body.toString().length - 1).split(",")); // trims brackets and divides each pair into . . .
    }).on('err', (err) => {
      reject(err);
    })
  });
}

async function processLogin(request, response) {
  let body = await _readBody(request);
  elArr = [];
  try {
    body.forEach(element => {
      element = element.replace(/\s+/g, ''); // get rid of whitespace
      element = element.split('='); // split the pairs, creating a 2d arr
      elArr.push(element); // . . . an array element
    });
    queries.find("select distinct * from users where Uname=? AND Hash=?", [elArr[0][1], elArr[1][1]], response);
  } catch (err) {
    console.log(err);
  }
  // at this point, `body` has the entire request body stored in it as a string
};


async function registerUser(request, response) {
  keyInserts = valInserts = "";
  let body = await _readBody(request);
  elArr = [];

  body.forEach((element, index) => {
    if (index !== 0) {
      keyInserts += ", ";
      valInserts += ", ";
    }
    element = element.replace(/\s+/g, ''); // get rid of whitespace
    element = element.split('='); // split the pairs, creating a 2d arr
    elArr.push(element);
    keyInserts += element[0];
    valInserts += element[1]; // . . . an array element
  });
  // = await queries.check("select distinct * from users where Uname=? AND Hash=?", [elArr[0][1], elArr[1][1]], response);  
  // sql = "insert into users (" + keyInserts + ") values (" + valInserts + ")";
  // queries.insert(sql, elArr, response);
  // at this point, `body` has the entire request body stored in it as a string
};

const server = http.createServer((req, res) => {
  if (req.method == 'GET') {
    //if (req.headers.host === hostname + ":" + port) {
    sendAdminLogin(req, res);
    //}
  } else if (req.method == 'PUT') {
    if (req.url === '/login') {
      processLogin(req, res);
    }
  } else if (req.method === 'POST') {
    if (req.url === '/register') {
      registerUser(req, res);
    }
  } else if (req.method === 'DELETE') {}
});

server.listen(port, hostname, () => {
  console.log("Server running at http://" + hostname + ':' + port);
});