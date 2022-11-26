use projeto;

db.createCollection("user",
    {
        validator: {
            $jsonSchema: {
                required: [
                    "email",
                    "name",
                    "address"
                ], properties: {
                    email: {
                        bsonType: "string", maxLength: 64, description: "Email."
                    }, name: {
                        bsonType: "string", maxLength: 64, description: "Name"
                    }, address: {
                        bsonType: "object", description: "Address", required: ["number", "street", "district"], properties: { "number": { bsonType: "string", maxLength: 32 }, "street": { bsonType: "string", maxLength: 64 }, "district": { bsonType: "string", maxLength: 64 }}
                    }
                }
            }
        }
    });