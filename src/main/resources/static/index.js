

function registrerBillett() {
    const billett = {
        filmvalg: $("#filmvalg").val(),
        antall: $("#antall").val(),
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        telefon: $("#klubb").val(),
        epost: $("#e-post").val(),
    };

    $.post("/registrerBillett", billett, function () {
        hentAlle();
    })
        .fail(function (jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#mld").html(json.message);
        });
}

function validerEpost() {
    const epost = $("#epost").val();
    const regex = /^[a-zæøåA-ZÆØÅ0-9 .@]{5,255}$/;
    const epostOK = regex.test(epost);

    if (epostOK) {
        $("#mld").html("");
        return true;
    }
    $("#mld").html("ugyldig input");
    return false;
}

function validerTlf() {
    const epost = $("#tlf").val();
    const regex = /^[0-9]{8$/;
    const epostOK = regex.test(epost);

    if (epostOK) {
        $("#mld").html("");
        return true;
    }
    $("#mld").html("ugyldig input");
    return false;
}

function hentAlle() {
    $.get("/hentAlle", function (billetter) {
        if (billetter.length > 0) {

            let output = "<table> <tr><th>Film </th></tr>" +
                "<tr><th>Fornavn</th></tr>" +
                "<tr><td>Etternavn</td></tr>" +
            "<tr><th>Telefon</th></tr>" +
                "<tr><th>Epost</th></tr>";



            for (let b of billetter) {
                output += "<tr><td>" + b.film + "</td></tr>" +
                    "<tr><td>" + b.fornavn + "</td></tr>" +
                    "<tr><td>" + b.etternavn + "</td></tr>" +
                    "<tr><td>" + b.telefon + "</td></tr>" +
                    "<tr><td>" + b.epost + "</td></tr>";
            }

            output += "</table>"

            $("#billetoversikt").html(output);
        } else {
            $("#billetoversikt").html("ingen billetter tilgjengelig");
        }
    })
        .fail(function (jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#mld").html(json.message);
        })
}


function slettAlle() {
    $.get("/slettalle", billett, function() {
        $("#billetoversikt").html("");
    });
}