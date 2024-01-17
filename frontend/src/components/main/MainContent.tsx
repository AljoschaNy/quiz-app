import "./MainContent.css";
import OptionCard from "./OptionCard.tsx";
import {Topic} from "../../types/types.ts";

function MainContent() {

    const topicsArray:Topic[] = [
        {id: "1", name:"HTML",path:"assets/icon-html.svg"},
        {id: "2", name:"CSS", path:"assets/icon-css.svg"},
        {id: "3", name:"Javascript", path:"assets/icon-js.svg"},
        {id: "4", name:"Accessibility", path:"assets/icon-accessibility.svg"}
    ];

    return (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <h1><span className={"intro-text"}>Welcome to the</span> Frontend Quiz!</h1>
                <p className={"info-text"}>Pick a subject to get started.</p>
            </section>

            <section className={"options-container"}>
                {topicsArray.map(topic => {
                    return <OptionCard key={topic.id} topic={topic}/>;
                })}
            </section>

        </main>
    );
}

export default MainContent;