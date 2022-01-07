## Bootcamp IT - MELI / DH

# Grupo 7

## Desafio 2

---

### API usage

---

<table>
    <tr>
        <td>METHOD</td>
        <td>ENDPOINT</td>
        <td>PAYLOAD</td>
        <td>QUERY</td>
        <td>RESPONSE</td>
        <td>ACTION</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/property/area</td>
        <td>{<br>
    <p style="margin-left:20px">
	"prop_name": "Propriedade",<br>
    "prop_district": "Bairro",<br>
    "value_district_m2": 10,<br>
    "rooms": [<br>
		<p style="margin-left:40px">
        {
            "room_width": 10,
            "room_length": 15,
            "room_name": "Room1"
        },<br>
        {
            "room_width": 10,
            "room_length": 30,
            "room_name": "Room2"
        },<br>
        {
            "room_width": 10,
            "room_length": 33,
            "room_name": "Room3"
        },<br>
        {
            "room_width": 10,
            "room_length": 30,
            "room_name": "Room4"
        },<br>
        {
            "room_width": 10,
            "room_length": 20,
            "room_name": "Room5"
        }<br>
		</p>
		]
	</p>
}</td>
    <td align="center">---</td>
    <td>{
    <p style="margin-left:20px">
    "totalArea": 1280.0,<br>
    "price": 12800.0,<br>
    "biggestRoom": "Room3",<br>
    "rooms": [<br>
		<p style="margin-left:40px">
        {
            "room_name": "Room1",
            "area": 150.0
        },<br>
        {
            "room_name": "Room2",
            "area": 300.0
        },<br>
        {
            "room_name": "Room3",
            "area": 330.0
        },<br>
        {
            "room_name": "Room4",
            "area": 300.0
        },<br>
        {
            "room_name": "Room5",
            "area": 200.0
        }<br>
    	]
		</p>
	</p>
	}</td>
        <td>Cadastra informações do imóvel: bairro, preço, cômodos, nome</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/resgiterDistrict</td>
        <td>{<br>
		<p style="margin-left:20px">
		"districts": [<br>
			{
				"name": "Parque Peruche"
			},<br>
			{
				"name": "Casa Verde"
			},<br>
			{
				"name": "Bairro"
			}<br>
		]
		</p>
		}</td>
        <td>---</td>
        <td>{<br>
			<p style="margin-left=20px">
			"message": "Bairros cadastrados com sucesso",<br>
			"status": "success"
			</p>
		}</td>
		<td>Cadastra informações do imóvel: bairro, preço, cômodos, nome</td>
	</tr>
    <tr>
        <td>GET</td>
        <td>/getDistricts</td>
        <td align="center">---</td>
        <td align="center">---</td>
        <td>{<br>
		<p style="margin-left:20px">
		"districts": [<br>
			{
				"name": "Parque Peruche"
			},<br>
			{
				"name": "Casa Verde"
			},<br>
			{
				"name": "Bairro"
			}<br>
		]
		</p>
		}</td>
		<td>Lista todos os Bairros disponíveis para registro de imóvel.</td>
	</tr>
</table>
