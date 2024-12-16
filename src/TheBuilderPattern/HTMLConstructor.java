// 5 ВАРИАНТ. Конструктор HTML-документов с использованием паттерна "Строитель".
package TheBuilderPattern;

// Класс HTMLTag для представления HTML-тегов
class HTMLTag {
    private String tagName;
    private String attributes = "";
    private String content = "";

    public HTMLTag(String tagName) {
        this.tagName = tagName;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "<" + tagName + (attributes.isEmpty() ? "" : " " + attributes) + ">" +
                content +
                "</" + tagName + ">";
    }
}

// Интерфейс Builder для создания HTML-тегов
interface HTMLBuilder {
    HTMLBuilder setAttributes(String attributes);
    HTMLBuilder setContent(String content);
    HTMLTag build();
}

// Конкретная реализация Builder
class HTMLTagBuilder implements HTMLBuilder {
    private HTMLTag tag;

    public HTMLTagBuilder(String tagName) {
        this.tag = new HTMLTag(tagName);
    }

    @Override
    public HTMLBuilder setAttributes(String attributes) {
        tag.setAttributes(attributes);
        return this;
    }

    @Override
    public HTMLBuilder setContent(String content) {
        tag.setContent(content);
        return this;
    }

    @Override
    public HTMLTag build() {
        return tag;
    }
}

// Демонстрация работы паттерна "Строитель"
public class HTMLConstructor {
    public static void main(String[] args) {
        // Создание HTML-тегов с использованием Builder
        HTMLTag divTag = new HTMLTagBuilder("div")
                .setAttributes("class='container' id='main'")
                .setContent("<p>Hello, World!</p>")
                .build();

        HTMLTag pTag = new HTMLTagBuilder("p")
                .setAttributes("style='color: red;'")
                .setContent("This is a paragraph.")
                .build();

        // Вывод созданных тегов
        System.out.println(divTag);
        System.out.println(pTag);
    }
}
