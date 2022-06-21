// https://app.quicktype.io/
export interface APIResponse {
    results?:  Result[];
    facets?:   Facets;
    total?:    number;
    meta?:     Meta;
    page?:     number;
    previous?: null;
    next?:     string;
}

export interface Facets {
    facet_queries?:   FacetQueries;
    facet_fields?:    FacetFields;
    facet_ranges?:    FacetHeatmaps;
    facet_intervals?: FacetIntervals;
    facet_heatmaps?:  FacetHeatmaps;
}

export interface FacetFields {
    format?:                          Format;
    subjects?:                        Subjects;
    topic_uuids?:                     { [key: string]: number };
    publishers_exact?:                { [key: string]: number };
    language?:                        LanguageClass;
    sharing_status?:                  SharingStatus;
    expert_playlist?:                 ExpertPlaylist;
    video_classification?:            VideoClassification;
    certification_name_exact?:        FacetHeatmaps;
    certification_vendor_name_exact?: FacetHeatmaps;
    topics?:                          { [key: string]: number };
}

export interface FacetHeatmaps {
}

export interface ExpertPlaylist {
    false?: number;
}

export interface Format {
    article?:                number;
    audiobook?:              number;
    book?:                   number;
    "learning path"?:        number;
    "live online training"?: number;
    playlists?:              number;
    scenario?:               number;
    video?:                  number;
}

export interface LanguageClass {
    en?: number;
}

export interface SharingStatus {
    public?: number;
}

export interface Subjects {
    "Core Programming"?: number;
    JavaScript?:         number;
    Engineering?:        number;
    "Google/Android"?:   number;
    "Web Development"?:  number;
}

export interface VideoClassification {
    conference?:   number;
    "case-study"?: number;
    other?:        number;
}

export interface FacetIntervals {
    average_rating?: AverageRating;
    issued?:         Issued;
}

export interface AverageRating {
    five_stars?:  number;
    four_stars?:  number;
    three_stars?: number;
    two_stars?:   number;
    one_star?:    number;
    zero_stars?:  number;
    no_stars?:    number;
}

export interface Issued {
    early_release?:   number;
    last_six_months?: number;
    last_year?:       number;
    last_two_years?:  number;
}

export interface FacetQueries {
    "{!ex=format}(format:video AND title_unstemmed:\"Learning Path: .*\")"?: number;
    non_enterprise_expert_playlists?:                                        number;
    total_playlists?:                                                        number;
    enterprise_playlists?:                                                   number;
}

export interface Meta {
    query_identifier?: string;
}

export interface Result {
    id?:                      string;
    archive_id?:              string;
    ourn?:                    string;
    isbn?:                    string;
    last_modified_time?:      Date;
    issued?:                  Date;
    format?:                  ContentFormat;
    content_format?:          ContentFormat;
    authors?:                 string[];
    publishers?:              string[];
    extended_publisher_data?: ExtendedPublisherData;
    academic_excluded?:       boolean;
    language?:                LanguageEnum;
    title?:                   string;
    description?:             string;
    url?:                     string;
    web_url?:                 string;
    source?:                  Source;
    content_type?:            ContentFormat;
    virtual_pages?:           number;
    duration_seconds?:        number;
    has_assessment?:          boolean;
    timestamp?:               Date;
    average_rating?:          number;
    number_of_followers?:     number;
    number_of_items?:         number;
    number_of_reviews?:       number;
    popularity?:              number;
    report_score?:            number;
    cover_url?:               string;
    date_added?:              Date;
    topics?:                  string[];
    highlights?:              Highlights;
    topics_payload?:          TopicsPayload[];
    video_classification?:    string;
}

export enum ContentFormat {
    Book = "book",
    MockingbirdV2ID = "mockingbird-v2-id",
    Video = "video",
}

export interface ExtendedPublisherData {
    web_url?: string;
}

export interface Highlights {
    content?:       string[];
    authors?:       string[];
    publishers?:    string[];
    title?:         string[];
    chapter_title?: any[];
}

export enum LanguageEnum {
    En = "en",
}

export enum Source {
    ApplicationEpubZip = "application/epub+zip",
    ApplicationPDF = "application/pdf",
}

export interface TopicsPayload {
    uuid?:  string;
    slug?:  string;
    name?:  string;
    score?: null;
}
