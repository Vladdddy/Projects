<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PortFolio</title>
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="contact.css">
    <link rel="icon" type="image/x-icon" href="img/icon.png">
    <script defer src="script.js"></script>
</head>
<body>
    <div class="navbar" id="navbar">
        <p><a href="#about">ABOUT ME</a></p>
        <p><a href="index.php#competencies">COMPETENCIES</a></p>
        <p><a href="index.php#certificates">CERTIFICATES</a></p>
        <p><a href="contact.php">CONTACT ME</a></p>
    </div>
<!--
<?php/*
$host = "localhost";
$username = "root";
$password = "";
$dbname = "";

// Connessione al database
$conn = new mysqli($host, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connessione fallita: " . $conn->connect_error);
}

// Funzione per inserire un nuovo articolo
if(isset($_POST['submit'])) {
    $nome = $_POST['nome'];
    $descrizione = $_POST['descrizione'];
    $prezzo = $_POST['prezzo'];
    $quantita = $_POST['quantita'];
    $codice_a_barre = $_POST['codice_a_barre'];

    $sql = "INSERT INTO articoli (nome, descrizione, prezzo, quantita, codice_a_barre) VALUES ('$nome', '$descrizione', '$prezzo', '$quantita', '$codice_a_barre')";
    if ($conn->query($sql) === TRUE) {
        echo "Articolo inserito con successo!";
    } else {
        echo "Errore durante l'inserimento dell'articolo: " . $conn->error;
    }
}

// Funzione per cercare un articolo per codice a barre
if(isset($_POST['search'])) {
    $codice_a_barre = $_POST['codice_a_barre'];

    $sql = "SELECT * FROM articoli WHERE codice_a_barre = '$codice_a_barre'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        echo "<h2>Risultati della ricerca:</h2>";
        $row = $result->fetch_assoc();
        echo "<p>Nome: " . $row['nome'] . "</p>";
        echo "<p>Descrizione: " . $row['descrizione'] . "</p>";
        echo "<p>Prezzo: " . $row['prezzo'] . "</p>";
        echo "<p>Quantità: " . $row['quantita'] . "</p>";
        echo "<p>Codice a barre: " . $row['codice_a_barre'] . "</p>";
    } else {
        echo "Articolo non trovato.";
    }
}*/
?>

<h2>Inserisci un nuovo articolo:</h2>
<form method="post" action="">
    <label>Nome:</label><br>
    <input type="text" name="nome" required><br>
    <label>Descrizione:</label><br>
    <textarea name="descrizione" required></textarea><br>
    <label>Prezzo:</label><br>
    <input type="number" step="0.01" name="prezzo" required><br>
    <label>Quantità:</label><br>
    <input type="number" name="quantita" required><br>
    <label>Codice a barre:</label><br>
    <input type="text" name="codice_a_barre" required><br>
    <input type="submit" name="submit" value="Inserisci">
</form>

<h2>Ricerca articolo per codice a barre:</h2>
<form method="post" action="">
    <label>Codice a barre:</label><br>
    <input type="text" name="codice_a_barre" required><br>
    <input type="submit" name="search" value="Cerca">
</form>
-->
</body>
</html>