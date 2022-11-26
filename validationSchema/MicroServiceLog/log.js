use logs;

db.createCollection("log",
    {
        validator: {
            $jsonSchema: {
                required: [
                    "spaceId",
                    "spaceName",
                    "user",
                    "collaboratorAccess"
                ], properties: {
                    spaceId: {
                        bsonType: "string", maxLength: 64, description: "Space ID."
                    }, spaceName: {
                        bsonType: "string", maxLength: 64, description: "Space Name."
                    }, user: {
                        bsonType: "string", maxLength: 64, description: "Collaborator User."
                    }, collaboratorAccess: {
                        bsonType: "string", maxLength: 64, description: "Collaborator Access."
                    }
                }
            }
        }
    });