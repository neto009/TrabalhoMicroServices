use logs
db.createCollection("logWorkspace", { capped: true, size: 1024, max: 50})
