import "./OptionCard.css";

type OptionCardProps = {
    imgPath: string,
    optionText: string
}

function OptionCard({ optionText, imgPath }:Readonly<OptionCardProps>) {
    return (
        <button className={"option-card"}>
            <img className={"topic-img"} src={imgPath} alt={"topic-icon"} />
            <span className={"option-text"}>{optionText}</span>
        </button>
    );
}

export default OptionCard;
