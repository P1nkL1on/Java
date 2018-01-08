// not a channels!!!

function addPerson(element) {
    var nameField = $('#newPersonName');
    $.ajax({
        url: "/persons",
        type: "PUT",
        contentType: "application/x-www-form-urlencoded",//"text/plain",
        data: $('newPerson').serialize()//nameField.val()
    }).done(function () {
        $.post("/persons", function (data) {
            $(".persons").html(data);
        });
    });
    nameField.val("");
}

function deletePerson(element) {
    var personId = $(element).closest(".person").find(".hide").html();
    $.ajax({
        url: "/persons/" + personId,
        type: "DELETE"
    }).done(function () {
        $.post("/persons", function (data) {
            $(".persons").html(data);
        });
    });
}