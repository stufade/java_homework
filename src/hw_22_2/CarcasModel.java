package hw_22_2;

public class CarcasModel {
    private IDocument<?> document;

    public CarcasModel() {
    }

    public CarcasModel(IDocument<?> document) {
        this.document = document;
    }

    public IDocument<?> getDocument() {
        return document;
    }

    public void setDocument(IDocument<?> document) {
        this.document = document;
    }
}
