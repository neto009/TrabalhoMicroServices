use projeto;

db.createCollection("workspace",
    {
        validator: {
            $jsonSchema: {
                required: [
                    "name",
                    "collaboratorList"
                ], properties: {
                    name: {
                        bsonType: "string", maxLength: 64, description: "Name of Workspace."
                    }, collaboratorList: {
                        bsonType: "array", description: "Collaboradores.", minItems: 1,
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