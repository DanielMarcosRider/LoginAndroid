const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
app.use(bodyParser.json());
app.use(cors());
const PORT = 3000;

const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'usuarios_bd'
});

db.connect(err => {
  if (err) throw err;
  console.log('Connected to MySQL');
});

app.listen(PORT, '0.0.0.0',() => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});

app.post('/login', (req, res) => {
  const { nombre_usuario, password } = req.body;

  const query = 'SELECT * FROM usuario WHERE nombre_usuario = ? AND password = ?';

  db.query(query, [nombre_usuario, password], (err, result) => {
    if (err) {
      console.error('Error al iniciar sesión:', err);
      res.status(500).json({ error: 'Error interno del servidor' });
      return;
    }

    if (result.length > 0) {
      res.status(200).json({ message: 'Inicio de sesión exitoso', user: result[0] });
    } else {
      res.status(401).json({ error: 'Credenciales incorrectas' });
    }
  });
});
