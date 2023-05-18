package groupa.project.springbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    private final InvoiceService invSer;

    public InvoiceController(InvoiceService invSer) {
        this.invSer = invSer;
    }

    @GetMapping("/invoices/{customerID}")
    public void getInvoice(@PathVariable int customerID) {
        //
        invSer.generateInvoice(132);
    }

    @PostMapping("/invoices/{customerID}")
    public String postID(@PathVariable String customerID) {
        return null;
    }
}
