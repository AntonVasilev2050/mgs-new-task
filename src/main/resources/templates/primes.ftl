<#-- @ftlvariable name="randomSixPrimesLists" type="kotlin.collections.List<com.avvsoft2050.models.FivePrimesRanges>" -->
<!DOCTYPE html>
<html lang = "en">
<head>
    <title>Primes</title>
</head>
<body style="text-align: center; font-family: sans-serif">
<h1>Generator of random primes </h1>
<hr>
    <p>
        ${randomSixPrimesLists}
    </p>
<hr>
<form action="/primes" method="get">

            <p>
                <input type="submit" value="СГЕНЕРИРОВАТЬ">
            </p>
</form>

<hr>
<form action="/primes" method="post">

            <p>
                <input type="submit" value="АВТО">
            </p>
</form>

<hr>
<form action="/primes" method="post">
            <p>
                <input type="text" name="length" value="30" min="10" max="100">
            </p>
            <p>
                <input type="submit" value="NEW ARRAY">
            </p>
</form>

</body>
</html>