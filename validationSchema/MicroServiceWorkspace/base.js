use projeto;

db.createCollection("base",
    {
        validator: {
            $jsonSchema: {
                required: [
                    "name",
                    "collaboratorList"
                ], properties: {
                    name: {
                        bsonType: "string", maxLength: 64, description: "Name of Base."
                    }, collaboratorList: {
                        bsonType: "array", description: "Collaboradores.",
                        items: {
                            bsonType: ["object"], description: "Array de Collaboradores",
                            properties: {
                                user: {
                                    bsonType: "object", description: "Users",
                                }, access: {
                                    bsonType: "string", description: "Access", maxLength: 10
                                }
                            }
                        }
                    }
                }
            }
        }
    });