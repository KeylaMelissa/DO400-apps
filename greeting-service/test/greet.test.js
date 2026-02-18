const assert = require("assert");
const greet = require("../greet");


describe("greet", () =>{

    module.exports = function greet(name) {
    return `Hello ${name || "guest"} from V3!`;
}

});
